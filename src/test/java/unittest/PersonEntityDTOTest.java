package unittest;

import com.baeldung.springboot.entity.Person;
import com.baeldung.springboot.model.dto.PersonDto;
import org.junit.Test;
import org.modelmapper.ModelMapper;

import static org.junit.Assert.assertEquals;

public class PersonEntityDTOTest {
	
	private static final ModelMapper modelMapper = new ModelMapper();
	
	@Test
	public void testRegisterRunnerDTO_ToEnityMapping(){
		
		PersonDto personDto = new PersonDto();
		
		personDto.setFirstName("FirstJava");
		personDto.setLastName("LastJava");
		personDto.setGender("M");
		personDto.setHomeRun("PUNE RUNNING");
		personDto.setRunningClub("RUNWAY");
		personDto.setPostCode("CW2ZZZ");
		personDto.setEmail("email@email.com");
		
		Person personEntity = modelMapper.map(personDto, Person.class);
		assertEquals(personDto.getFirstName(), personEntity.getFirstName());
		assertEquals(personDto.getLastName(), personEntity.getLastName());
		assertEquals(personDto.getGender(), personEntity.getGender());
		assertEquals(personDto.getHomeRun(), personEntity.getHomeRun());
		assertEquals(personDto.getRunningClub(), personEntity.getRunningClub());
		assertEquals(personDto.getEmail(), personEntity.getEmail());
		
	}
	
}
