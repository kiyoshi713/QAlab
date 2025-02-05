package com.nttdata.steps;
//SerenityRest.given().baseUri(URL_BASE).relaxedHTTPSValidation().log().all().when()/*.get("https://petstore.swagger.io/v2/pet/566") */.get("pet/"+String.valueOf(idMascota)).then().log().all();
import net.serenitybdd.rest.SerenityRest;
import org.junit.Assert;
import java.util.Date;
public class MascotaStep {

    private String StoreOrder= "https://petstore.swagger.io/v2/store/order";
    private String URL= "https://petstore.swagger.io/v2/store/order/";
    public void validarorden(int id, int petId, int quantity, Date shipdate, String status) {
        SerenityRest.given()
                .contentType("application/json")
                .relaxedHTTPSValidation()
                .body("{\n" +
                        "  \"id\": \"+id+\",\n" +
                        "  \"petId\": \"+petId+\",\n" +
                        "  \"quantity\": \"+quantity+\",\n" +
                        "  \"shipDate\": \""+shipdate+"\",\n" +
                        "  \"status\": \""+status+"\",\n" +
                        "  \"complete\": \"+false+\",\n" +
                        "}")
                .log().all()
                .post(StoreOrder)
                .then()
                .log().all()
        ;}

    public void ValidarBody(int id, int petId, int quantity, Date shipdate, String status) {
        int id1 = SerenityRest.lastResponse().getBody().path("id");
        int petId1 = SerenityRest.lastResponse().getBody().path("petId");
        int quantity1 = SerenityRest.lastResponse().getBody().path("quantity");
        Date shipdate1 = SerenityRest.lastResponse().getBody().path("shipDate");
        String status1 = SerenityRest.lastResponse().getBody().path("status");

        Assert.assertEquals(id, id1);
        Assert.assertEquals(petId, petId1);
        Assert.assertEquals(quantity, quantity1);
        Assert.assertEquals(shipdate, shipdate1);
        Assert.assertEquals(status, status1);}


    public void validarRespuesta(int StatusCode) {
        Assert.assertEquals(StatusCode,SerenityRest.lastResponse().getStatusCode());

    }

    public void consultarPorOrderId(int orderId) {
        SerenityRest.given()
                .contentType("application/json")
                .log()
                .all()
                .get(URL+orderId);
    }
}
