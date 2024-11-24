package com.studyspring.unittests.mapper;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;

import com.studyspring.mapper.PersonMapper;
import com.studyspring.models.Person;
import com.studyspring.unittests.MockPerson;
import com.studyspring.vo.PersonVO;

public class PersonMapperTest {

    private final MockPerson input = new MockPerson();

    private final PersonMapper mapper = Mappers.getMapper(PersonMapper.class);

    @Test
    void testVoToPerson() {
        PersonVO vo = input.mockVO();
        Person person = mapper.voToPerson(vo);

        assertNotNull(person);
        assertEquals(vo.getKey(), person.getId());
        assertEquals(vo.getFirstName(), person.getFirstName());
        assertEquals(vo.getLastName(), person.getLastName());
        assertEquals(vo.getAddress(), person.getAddress());
        assertEquals(vo.getGender(), person.getGender());
    }

    @Test
    void testPersonToVO() {
        Person person = input.mockEntity(1);
        PersonVO vo = mapper.personToVO(person);

        assertNotNull(vo);
        assertEquals(person.getId(), vo.getKey());
        assertEquals(person.getFirstName(), vo.getFirstName());
        assertEquals(person.getLastName(), vo.getLastName());
        assertEquals(person.getAddress(), vo.getAddress());
        assertEquals(person.getGender(), vo.getGender());
    }

    @Test
    void testPersonListToVOList() {
        List<Person> personList = input.mockEntityList();
        List<PersonVO> voList = mapper.personListToVOList(personList);

        assertNotNull(voList);
        assertEquals(10, voList.size());
        assertEquals(personList.get(0).getId(), voList.get(0).getKey());
        assertEquals(personList.get(1).getId(), voList.get(1).getKey());
    }

    @Test
    void testVOListToPersonList() {
        List<PersonVO> voList = input.mockVOList();
        List<Person> personList = mapper.voListToPersonList(voList);

        assertNotNull(personList);
        assertEquals(10, personList.size());

		for (var person : personList) {
			assertNotNull(person);
			assertNotNull(person.getId());

			long id = person.getId();
			assertEquals("First Name Test" + id, person.getFirstName());
			assertEquals("Last Name Test" + id, person.getLastName());
			assertEquals("Addres Test" + id, person.getAddress());
			if (((int)id % 2) == 0)
				assertEquals("Male", person.getGender());
			else 
				assertEquals("Female", person.getGender());
		}
    }
}
