package com.g5.g5api;

import com.g5.g5api.models.Menu;
import com.g5.g5api.service.MenuService;
import com.g5.g5api.service.MenuServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.*;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class G5ApiApplicationTests {

    /*private TestRestTemplate testRestTemplate;

    @Autowired
    RestTemplateBuilder restTemplateBuilder;

    @BeforeEach
    public void setUp() {
        restTemplateBuilder = restTemplateBuilder.rootUri("http://localhost:8080");
        testRestTemplate = new TestRestTemplate(restTemplateBuilder);
    }

    *//**
     * Guardar un Menu
     *//*

    @Test
    void guardarMenuTest() {
        Menu menu = new Menu();
        menu.setFecha("2022-12-12");
        ArrayList<Integer> idProductos = new ArrayList<>();
        idProductos.add(1);
        idProductos.add(2);
        menu.setIdProductos(idProductos);

        Menu menuGuardado = testRestTemplate.postForObject("/menu", menu, Menu.class);

        assertNotNull(menuGuardado);
    }

    @Test
    void menuFechaIncorrectaTest() {
        Menu menu = new Menu();
        menu.setFecha("2022-12-12-12");
        ArrayList<Integer> idProductos = new ArrayList<>();
        idProductos.add(1);
        idProductos.add(2);
        menu.setIdProductos(idProductos);

        Menu menuGuardado = testRestTemplate.postForObject("/menu", menu, Menu.class);

        assertNull(menuGuardado);

    }

    @Test
    void menuProductoIncorrectoTest() {
        Menu menu = new Menu();
        menu.setFecha("2022-12-12");
        ArrayList<Integer> idProductos = new ArrayList<>();
        idProductos.add(30000);
        menu.setIdProductos(idProductos);

        Menu menuGuardado = testRestTemplate.postForObject("/menu", menu, Menu.class);

        assertNull(menuGuardado);

    }

    *//**
     * Actualizar un Menu
     *//*

    @Test
    void actualizarMenuTest() {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));

        String body = "{\"idMenu\":3,\"fecha\":\"2022-12-12\",\"idProductos\":[1,2]}";

        HttpEntity<String> request = new HttpEntity<>(body, headers);

        ResponseEntity<Menu> response = testRestTemplate.exchange("/menu", HttpMethod.PUT, request, Menu.class);

        assertEquals(HttpStatus.OK, response.getStatusCode());
    }

    @Test
    void actualizarMenuIdIncorrecto() {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));

        String body = "{\"idMenu\":10000,\"fecha\":\"2022-12-12\",\"idProductos\":[1,2]}";

        HttpEntity<String> request = new HttpEntity<>(body, headers);

        ResponseEntity<Menu> response = testRestTemplate.exchange("/menu", HttpMethod.PUT, request, Menu.class);

        assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
    }

    @Test
    void actualizarMenuFechaIncorrecta() {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));

        String body = "{\"idMenu\":1,\"fecha\":\"2022-12-12-12\",\"idProductos\":[1,2]}";

        HttpEntity<String> request = new HttpEntity<>(body, headers);

        ResponseEntity<Menu> response = testRestTemplate.exchange("/menu", HttpMethod.PUT, request, Menu.class);

        assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
    }

    @Test
    void actualizarMenuProductoIncorrecto() {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));

        String body = "{\"idMenu\":1,\"fecha\":\"2022-12-12\",\"idProductos\":[30000]}";

        HttpEntity<String> request = new HttpEntity<>(body, headers);

        ResponseEntity<Menu> response = testRestTemplate.exchange("/menu", HttpMethod.PUT, request, Menu.class);

        assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
    }

    *//**
     * Eliminar un Menu
     *//*

    @Test
    void eliminarMenuTest() {
        // testear REsponse entity
        ResponseEntity<String> response = testRestTemplate.exchange("/menu/11",
                HttpMethod.DELETE, null, String.class);

        assertEquals(HttpStatus.OK, response.getStatusCode());

    }

    @Test
    void eliminarMenuIdIncorrectoTest() {
        ResponseEntity<String> response = testRestTemplate.exchange("/menu/10000",
                HttpMethod.DELETE, null, String.class);
        assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
    }

    *//**
     * Obtener un Menu
     *//*

    @Test
    void obtenerMenuTest() {
        Menu menu = testRestTemplate.getForObject("/menu/3", Menu.class);
        assertNotNull(menu);
    }

    @Test
    void obtenerMenuIdIncorrectoTest() {
        Menu menu = testRestTemplate.getForObject("/menu/10000", Menu.class);
        assertNull(menu.getIdProductos());
    }*/

}
