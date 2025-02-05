package com.nttdata.glue;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import com.nttdata.steps.MascotaStep;

import java.util.Date;


public class MascotaStepdefs {
    MascotaStep mascota = new MascotaStep();
    //primera prueba
    @When("Ingreso la orden de mascota con id {int}, petId {int}, quantity {int}, shipDate {string}, status {string}, complete false")
    public void consultoLaOrdenDeMascotaConIdPetIdQuantityShipDateStatusCompleteFalse(int id, int petId, int quantity, Date shipdate, String status) {
        mascota.validarorden(id, petId,  quantity, shipdate, status);}

    @Then("valido el codigo de respuesta {int}")
    public void validoElCodigoDeRespuesta(int status) {mascota.validarRespuesta(status);
    }
    @And("valido que el body de la respuesta sea  {int}, petId {int}, quantity {int}, shipDate {string}, status {string}, complete false")
    public void validoQueElBodyDeLaRespuestaSeaPetIdQuantityShipDateStatusCompleteFalse(int id, int petId, int quantity, Date shipdate, String status) {
        mascota.ValidarBody(id, petId,  quantity, shipdate, status);}

    @When("Consulto la orden de mascota con orderId {int}")
    public void consultoLaOrdenDeMascotaConOrderId(int orderId) {
        mascota.consultarPorOrderId(orderId);
    }

    //segunda prueba

}
