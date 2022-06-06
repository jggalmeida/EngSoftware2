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

import com.projects.praticandoAPI.controller.dto.LivroDto;
import com.projects.praticandoAPI.controller.form.LivroForm;


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@RunWith(SpringRunner.class)
public class LivroTests {

    @Autowired
    private TestRestTemplate testRestTemplate;
    
    @Test
    public void criarNovoLivro() {
        LivroForm form = new LivroForm();
        form.setNomeLivro("Pequeno");
            
        HttpEntity<LivroForm> httpEntity = new HttpEntity<>(form);

        ResponseEntity<LivroDto> response = this.testRestTemplate
                .exchange("/livros", HttpMethod.POST, httpEntity, LivroDto.class);

        //assertEquals(response.getStatusCode(), HttpStatus.CREATED);
        assertEquals(response.getBody().getNomeLivro(), "Pequeno Principe");
    }

    @Test
    public void listaLivro() {
        ResponseEntity<LivroDto[]> response = this.testRestTemplate
                .exchange("/livros", HttpMethod.GET, null, LivroDto[].class);

        assertEquals(response.getStatusCode(), HttpStatus.OK);
    }
        
}
		
	


       


