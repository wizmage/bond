package net.kepco.srm;

import static org.junit.Assert.assertTrue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.system.CapturedOutput;
import org.springframework.boot.test.system.OutputCaptureExtension;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import lombok.extern.slf4j.Slf4j;
import net.kepco.srm.boot.BondBootApplication;

@Slf4j
@ActiveProfiles("test")
@RunWith(SpringRunner.class)
@SpringBootTest(classes = BondBootApplication.class)
@AutoConfigureMockMvc
@ExtendWith(OutputCaptureExtension.class)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class SampleControllerTest {

	@Autowired
    MockMvc mockMvc;

	@Test
	@Order(5)
	void testSelectSampleList(CapturedOutput capturedOutput) throws Exception {
		log.debug("testSelectSampleList ============================");
		mockMvc.perform(get("/api/v1/sample/selectSampleList.json"))
				.andDo(print())
				.andExpect(status().isOk());
		
		assertTrue(capturedOutput.toString().contains("Slf4j"));
	}

	@Test
	@Order(4)
	void testSelectSample() throws Exception {
		log.debug("testSelectSample ============================");
	}
	
	@Test
	@Order(2)
	void testAddSample() throws Exception {
		log.debug("testAddSample ============================");
	} 	

	@Test
	@Order(3)
	void testUpdateSample() throws Exception {
		log.debug("testUpdateSample ============================");
	}

	@Test
	@Order(1)
	void testDeleteSample(CapturedOutput capturedOutput) throws Exception {
		log.debug("testDeleteSample ============================");
		mockMvc.perform(get("/api/v1/sample/selectSampleList.json?id=SAMPLE-00114"))
				.andDo(print())
				.andExpect(status().isOk());
		
		assertTrue(capturedOutput.toString().contains("Slf4j"));
	}

}
