import com.hotel.dto.*;
import com.hotel.repository.HotelDAO;
import com.hotel.service.HotelService;
import com.hotel.utils.ValidationException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
public class HotelServiceImplTest {

    @Mock
    HotelDAO hotelDAO;

    @InjectMocks
    HotelService hotelService;

    @Test(expected = ValidationException.class)
    public void testSerivceWithoutValues(){
        hotelService.bookHotelRoom(null);
    }

    @Test(expected = Exception.class)
    public void testBookHotelRoomWithValues(){
        HotelInput hotelInput = new HotelInput();
        hotelInput.setCustomerId(339348383l);
        hotelInput.setHotelManageInput(getInputDetails());
        hotelService.bookHotelRoom(hotelInput);
    }

    @Test
    public void testBookHotelRoom(){
        HotelInput hotelInput = new HotelInput();
        hotelInput.setCustomerId(339348383l);
        hotelInput.setHotelManageInput(getInputDetails());
        Mockito.when(hotelDAO.findAll()).thenReturn(getHotels());
        hotelService.bookHotelRoom(hotelInput);
    }

    private List<Hotel> getHotels(){
        List<Hotel>  hotelList = new ArrayList<>();
        Hotel hotelTaj = new Hotel();
        hotelTaj.setCost(3000);
        hotelTaj.setHotelName("Taj");
        hotelTaj.setId(1l);
        hotelTaj.setLocaiton("Mumbai");
        hotelTaj.setMobileNumber("99999999");
        hotelTaj.setRoomAval("YES");
        hotelList.add(hotelTaj);

        Hotel hotelSahara = new Hotel();
        hotelSahara.setCost(2500);
        hotelSahara.setHotelName("Sahara");
        hotelSahara.setId(2l);
        hotelSahara.setLocaiton("Pune");
        hotelSahara.setMobileNumber("99999900");
        hotelSahara.setRoomAval("YES");
        hotelList.add(hotelSahara);

        Hotel hotelBarbeque = new Hotel();
        hotelBarbeque.setCost(2500);
        hotelBarbeque.setHotelName("Sahara");
        hotelBarbeque.setId(2l);
        hotelBarbeque.setLocaiton("Pune");
        hotelBarbeque.setMobileNumber("99999900");
        hotelBarbeque.setRoomAval("YES");
        hotelList.add(hotelBarbeque);

        return hotelList;
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
