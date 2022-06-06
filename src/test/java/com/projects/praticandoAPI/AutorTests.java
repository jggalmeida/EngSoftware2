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

import com.projects.praticandoAPI.controller.dto.AutorDto;
import com.projects.praticandoAPI.controller.form.AutorForm;


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@RunWith(SpringRunner.class)
public class AutorTests {

    @Autowired
    private TestRestTemplate testRestTemplate;
    
    @Test
    public void criarNovoAutor() {
        AutorForm form = new AutorForm();
        form.setNomeAutor("Carlos Drummond");
        form.setNacionalidadeAutor("Brasileiro");        

        HttpEntity<AutorForm> httpEntity = new HttpEntity<>(form);

        ResponseEntity<AutorDto> response = this.testRestTemplate
                .exchange("/autores", HttpMethod.POST, httpEntity, AutorDto.class);

        assertEquals(response.getStatusCode(), HttpStatus.CREATED);
        assertEquals(response.getBody().getNomeAutor(), "Carlos Drummond");
    }

    @Test
    public void listaAutores() {
        ResponseEntity<AutorDto[]> response = this.testRestTemplate
                .exchange("/autores", HttpMethod.GET, null, AutorDto[].class);

        assertEquals(response.getStatusCode(), HttpStatus.OK);
    }
        
}
		
	


       


