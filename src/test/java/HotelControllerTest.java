import com.hotel.controller.HotelController;
import com.hotel.dto.*;
import com.hotel.service.HotelService;
import com.hotel.utils.ValidationException;
import com.sun.xml.internal.ws.developer.MemberSubmissionAddressing;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
public class HotelControllerTest {

    @InjectMocks
    HotelController hotelController;

    @Mock
    HotelService hotelService;

    @Test(expected = Exception.class)
    public void mockControllerObjectNull(){
        hotelController.bookHotelRoom(23223l,null,"1",null);
    }

    @Test
    public void mockControllerWithAllVals(){
        HotelInput hotelInput = new HotelInput();
        hotelInput.setCustomerId(339348383l);
        hotelInput.setHotelManageInput(getInputDetails());
        Mockito.when(hotelService.bookHotelRoom(hotelInput)).thenReturn(getHotelResponse());
        hotelController.bookHotelRoom(339348383l,getInputDetails(),"1",null);
    }

    public ResponseEntity<HotelResponseOutput> getHotelResponse(){
        HotelResponseOutput hotelResponseOutput = new HotelResponseOutput();
        HotelResponseData responseData = new HotelResponseData();
        HotelResponseAttribute attribute = new HotelResponseAttribute();
        attribute.setStatus("Success..!! " + getInputDetails().getHotelManageData().getHotelManageAttributes().getHotelDetails().getRoom() + " rooms booked\"");
        responseData.setHotelResponseAttribute(attribute);
        hotelResponseOutput.setData(responseData);
        return new ResponseEntity<HotelResponseOutput>(hotelResponseOutput,new HttpHeaders(), HttpStatus.OK);
    }

    private HotelManageInput getInputDetails(){
        HotelManageInput hotelManageInput = new HotelManageInput();
        HotelManageData hotelManageData = new HotelManageData();
        HotelManageAttribute hotelManageAttribute = new HotelManageAttribute();
        HotelDetails hotelDetails = new HotelDetails();
        hotelDetails.setBonusPoints(3000);
        hotelDetails.setCustomerName("Biden");
        hotelDetails.setHotelName("Taj");
        hotelDetails.setLocation("Mumbai");
        hotelDetails.setRoom(1);
        hotelDetails.setDays(1);
        hotelManageAttribute.setHotelDetails(hotelDetails);
        hotelManageData.setHotelManageAttributes(hotelManageAttribute);
        hotelManageInput.setHotelManageData(hotelManageData);

        return hotelManageInput;
    }
}
