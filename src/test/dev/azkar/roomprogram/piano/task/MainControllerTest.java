package dev.azkar.roomprogram.piano.task;


import dev.azkar.roomprogram.piano.task.controller.MainController;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class MainControllerTest {

    @Autowired
    MainController controller;

    @Autowired
    MockMvc mockMvc;

    @Test
    public void getQuestions() throws Exception {
        mockMvc.perform(get("/check?roomId=4&entrance=false&keyId=1"))
                .andDo(print())
                .andExpect(status().isOk());
    }


}
