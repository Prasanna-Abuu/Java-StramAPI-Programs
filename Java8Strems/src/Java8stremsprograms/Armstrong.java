package Java8stremsprograms;

import java.util.Scanner;

public class Armstrong {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int number = scanner.nextInt();
        scanner.close();

        boolean isArmstrong = String.valueOf(number)
                .chars()
                .map(Character::getNumericValue) 
                .mapToDouble(digit -> Math.pow(digit, String.valueOf(number).length())) // Calculate the cube of each digit
                .sum() == number; 
        if (isArmstrong) {
            System.out.println(number + " is an Armstrong number.");
        } else {
            System.out.println(number + " is not an Armstrong number.");
        }
    }
}

---------------------------------------------------------


    
import com.yourpackage.model.PPFBranchReqDtls;
import com.yourpackage.model.PersonalDetails;
import com.yourpackage.repo.PPFBranchReqDtlsRepo;
import com.yourpackage.repo.PersonalDetailsRepo;
import com.yourpackage.service.AmlockDetails;
import com.yourpackage.service.InvokeService;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class AmlockDetailsTest {

    @InjectMocks
    private AmlockDetails amlockDetails;

    @Mock
    private PPFBranchReqDtlsRepo ppfBranchReqDtlsRepo;

    @Mock
    private PersonalDetailsRepo personalDetailsRepo;

    @Mock
    private InvokeService invokeService;

    private PPFBranchReqDtls reqDtls;
    private PersonalDetails personalDetails;

    @BeforeEach
    void setup() {
        reqDtls = new PPFBranchReqDtls();
        reqDtls.setApplicationId(100L);
        reqDtls.setPersonalDtlId(200L);
        reqDtls.setCif("123456");
        reqDtls.setCustomerName("John Doe");

        personalDetails = new PersonalDetails();
        personalDetails.setId(200L);
        personalDetails.setDateOfBirth("01-01-1990");
    }

    // -----------------------------------------------------------------------
    // TEST 1: getCustDataFromCache() SUCCESS
    // -----------------------------------------------------------------------
    @Test
    void testGetCustDataFromCache_Success() throws Exception {

        when(ppfBranchReqDtlsRepo.findByApplicationId(100L))
                .thenReturn(Optional.of(reqDtls));

        when(personalDetailsRepo.findById(200L))
                .thenReturn(Optional.of(personalDetails));

        // Mock InvokeService core-banking call
        Map<String, Object> mockEisResponse = new HashMap<>();
        mockEisResponse.put("ERROR_CODE", "");
        mockEisResponse.put("msgStatus", 0);
        mockEisResponse.put("RESPONSE_STATUS", "0");
        mockEisResponse.put("ERROR_DESCRIPTION", "");
        mockEisResponse.put("REQUEST_REFERENCE_NUMBER", "REF123");

        when(invokeService.callInvokeService(anyString(), anyMap()))
                .thenReturn(mockEisResponse);

        Map<String, Object> result =
                amlockDetails.getCustDataFromCache(100L);

        assertNotNull(result);
        assertEquals("", result.get("ERROR_CODE"));
        assertNotNull(result.get("EIS_RESPONSE"));
    }

    // -----------------------------------------------------------------------
    // TEST 2: getCustDataFromCache() - APPLICATION NOT FOUND
    // -----------------------------------------------------------------------
    @Test
    void testGetCustDataFromCache_ApplicationNotFound() {

        when(ppfBranchReqDtlsRepo.findByApplicationId(100L))
                .thenReturn(Optional.empty());

        assertThrows(Exception.class, () -> {
            amlockDetails.getCustDataFromCache(100L);
        });
    }

    // -----------------------------------------------------------------------
    // TEST 3: getCustDataFromCache() - PERSONAL DETAILS NOT FOUND
    // -----------------------------------------------------------------------
    @Test
    void testGetCustDataFromCache_PersonalDetailsNotFound() {

        when(ppfBranchReqDtlsRepo.findByApplicationId(100L))
                .thenReturn(Optional.of(reqDtls));

        when(personalDetailsRepo.findById(200L))
                .thenReturn(Optional.empty());

        assertThrows(Exception.class, () -> {
            amlockDetails.getCustDataFromCache(100L);
        });
    }

    // -----------------------------------------------------------------------
    // TEST 4: getAmlockDetails() SUCCESS
    // -----------------------------------------------------------------------
    @Test
    void testGetAmlockDetails_Success() throws Exception {

        // Mock core banking response
        Map<String, Object> mockEisResponse = new HashMap<>();
        mockEisResponse.put("ERROR_CODE", "");
        mockEisResponse.put("msgStatus", 0);
        mockEisResponse.put("RESPONSE_STATUS", "0");
        mockEisResponse.put("ERROR_DESCRIPTION", "");
        mockEisResponse.put("REQUEST_REFERENCE_NUMBER", "REF999");

        when(invokeService.callInvokeService(anyString(), anyMap()))
                .thenReturn(mockEisResponse);

        Map<String, Object> result =
                amlockDetails.getAmlockDetails("123456", "01-01-1990", "John Doe");

        assertNotNull(result);
        assertEquals("", result.get("ERROR_CODE"));
        assertEquals("0", result.get("RESPONSE_STATUS"));
        assertEquals("REF999", result.get("REQUEST_REFERENCE_NUMBER"));

        Map<String, Object> inner = (Map<String, Object>) result.get("EIS_RESPONSE");
        assertNotNull(inner.get("requestId"));
    }

    // -----------------------------------------------------------------------
    // TEST 5: getAmlockDetails() - InvokeService exception handling
    // -----------------------------------------------------------------------
    @Test
    void testGetAmlockDetails_InvokeServiceFailure() throws Exception {

        when(invokeService.callInvokeService(anyString(), anyMap()))
                .thenThrow(new RuntimeException("Service Down"));

        assertThrows(RuntimeException.class, () -> {
            amlockDetails.getAmlockDetails("123456", "01-01-1990", "John Doe");
        });
    }
}

-----------------------------------------------------------------------------------------





    public Map<String, Object> getAmlockDetails(String cifNumber,
                                            String dateOfBirth,
                                            String customerName)
        throws ServiceBusinessException, ServiceException, JSONException {

    String methodName = "getAmlockDetails";

    String requestId = generateRequestId();

    // Build ScanChk
    Map<String, Object> scanChk = new HashMap<>();
    scanChk.put("IDNumber", cifNumber);
    scanChk.put("BirthDate", dateOfBirth);
    scanChk.put("CustomerName", customerName);
    scanChk.put("IndividualFlag", "I");

    // Build Header
    Map<String, Object> scanHeader = new HashMap<>();
    scanHeader.put("time", LocalDateTime.now().toString());
    scanHeader.put("sourceId", "Y");
    scanHeader.put("destination", "SHI SP2");
    scanHeader.put("txnType", "AMLOCK ONLINE ESS");
    scanHeader.put("txnSubType", "SCREENING DATA");
    scanHeader.put("requestId", requestId);

    // Build EIS Payload
    Map<String, Object> eisPayload = new HashMap<>();
    eisPayload.put("ScanChk", scanChk);
    eisPayload.put("ScanHeader", scanHeader);

    // Main Request Body
    Map<String, Object> getCustDetailsPayload = new HashMap<>();
    getCustDetailsPayload.put("SOURCE_ID", "Y");
    getCustDetailsPayload.put("DESTINATION", "SHI SP2");
    getCustDetailsPayload.put("TXN_TYPE", "AMLOCK ONLINE ESS");
    getCustDetailsPayload.put("TXN_SUB_TYPE", "SCREENING DATA");
    getCustDetailsPayload.put("REQUEST_ID", requestId);
    getCustDetailsPayload.put("EIS_PAYLOAD", eisPayload);

    Map<String, Object> requestMap = new HashMap<>();
    requestMap.put("GetAmlockDetailsIntReq", getCustDetailsPayload);

    // Call service → EIS response
    Map<String, Object> eisResponse =
            callInvokeService("eis_ppbranch_app_foramlockdetails", requestMap);

    // --------------------------------------------
    //    Extract Score , requestId , msgStatus
    // --------------------------------------------

    Integer score = null;

    try {
        // Get MatcInfo array
        List<Map<String, Object>> matchInfoList =
                (List<Map<String, Object>>) eisResponse.get("MatcInfo");

        if (matchInfoList != null && !matchInfoList.isEmpty()) {

            Map<String, Object> firstMatchInfo = matchInfoList.get(0);

            Map<String, Object> matchObj =
                    (Map<String, Object>) firstMatchInfo.get("Match");

            if (matchObj != null && matchObj.get("Score") != null) {
                score = Integer.parseInt(matchObj.get("Score").toString());
            }
        }
    } catch (Exception e) {
        System.out.println("Error parsing score: " + e.getMessage());
    }

    String eisRequestId = (String) eisResponse.get("requestId");
    Object msgStatus = eisResponse.get("msgStatus");

    // --------------------------------------------
    // Final Response
    // --------------------------------------------

    Map<String, Object> finalResponse = new HashMap<>();
    finalResponse.put("ERROR_CODE", eisResponse.get("ERROR_CODE"));

    // EIS extracted fields
    Map<String, Object> inner = new HashMap<>();
    inner.put("score", score);                 // 97
    inner.put("requestId", eisRequestId);      // SBI####
    inner.put("msgStatus", msgStatus);         // 1

    finalResponse.put("EIS_RESPONSE", inner);
    finalResponse.put("RESPONSE_STATUS", eisResponse.get("RESPONSE_STATUS"));
    finalResponse.put("ERROR_DESCRIPTION", eisResponse.get("ERROR_DESCRIPTION"));
    finalResponse.put("REQUEST_REFERENCE_NUMBER", eisResponse.get("REQUEST_REFERENCE_NUMBER"));

    return finalResponse;
}
