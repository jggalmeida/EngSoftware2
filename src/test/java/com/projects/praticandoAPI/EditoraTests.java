package com.projects.praticandoAPI;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import static org.junit.Assert.assertEquals;

import com.projects.praticandoAPI.controller.dto.EditoraDto;
import com.projects.praticandoAPI.controller.form.EditoraForm;


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@RunWith(SpringRunner.class)
public class EditoraTests {

    @Autowired
    private TestRestTemplate testRestTemplate;
    
    @Test
    public void criarNovaEditora() {
        EditoraForm form = new EditoraForm();
        form.setNomeEditora("Globo");
        form.setPaisEditora("Brasil");        

        HttpEntity<EditoraForm> httpEntity = new HttpEntity<>(form);

        ResponseEntity<EditoraDto> response = this.testRestTemplate
                .exchange("/editoras", HttpMethod.POST, httpEntity, EditoraDto.class);

        assertEquals(response.getStatusCode(), HttpStatus.CREATED);
        assertEquals(response.getBody().getNomeEditora(), "Globo");
    }

    @Test
    public void listaEditora() {
        ResponseEntity<EditoraDto[]> response = this.testRestTemplate
                .exchange("/editoras", HttpMethod.GET, null, EditoraDto[].class);

        assertEquals(response.getStatusCode(), HttpStatus.OK);
    }
        
}
		
	


       


