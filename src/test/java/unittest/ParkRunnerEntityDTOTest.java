package unittest;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.modelmapper.ModelMapper;

import com.baeldung.springboot.entity.ParkRunner;
import com.baeldung.springboot.model.dto.PartialUpdateDTO;
import com.baeldung.springboot.model.dto.PersonDto;

/**
 * 
 * @author Neeraj Sidhaye
 *  
 */

public class ParkRunnerEntityDTOTest {
	
	private static final ModelMapper modelMapper = new ModelMapper();
	
	
	@Test
	public void testPartialUpdateDTO_ToEntityMapping() {
		
		PartialUpdateDTO partialUpdateDTO = new PartialUpdateDTO();
		
		partialUpdateDTO.setTotalRuns("110");
		
	   ParkRunner parkRunner = modelMapper.map(partialUpdateDTO, ParkRunner.class);
	   assertEquals(partialUpdateDTO.getTotalRuns(), parkRunner.getTotalRuns());
		
	}
	
	
	@Test
	public void testRegisterRunnerDTO_ToEnityMapping(){
		
		PersonDto personDto = new PersonDto();
		
		personDto.setFirstName("Neeraj");
		personDto.setLastName("Sidhaye");
		personDto.setGender("M");
		personDto.setHomeRun("PUNE RUNNING");
		personDto.setRunningClub("RUNWAY");
		personDto.setPostCode("CW2ZZZ");
		personDto.setEmail("email@email.com");
		
		ParkRunner parkRunnerEntity = modelMapper.map(personDto, ParkRunner.class);
		assertEquals(personDto.getFirstName(), parkRunnerEntity.getFirstName());
		assertEquals(personDto.getLastName(), parkRunnerEntity.getLastName());
		assertEquals(personDto.getGender(), parkRunnerEntity.getGender());
		assertEquals(personDto.getHomeRun(), parkRunnerEntity.getHomeRun());
		assertEquals(personDto.getRunningClub(), parkRunnerEntity.getRunningClub());
		assertEquals(personDto.getEmail(), parkRunnerEntity.getEmail());
		
	}
	
}
