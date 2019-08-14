package t1707m.spring.controller;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import t1707m.spring.dto.EmiOperator2Dto;
import t1707m.spring.dto.Restdto;
import t1707m.spring.rest.RESTResponse;

import java.util.Map;


@CrossOrigin
@RestController
@RequestMapping(value = "/api/bank")
public class BankController {
     public double EIM;
    @RequestMapping(method = RequestMethod.POST, value = "/calculate")
    public ResponseEntity<Object> getEIM(@RequestBody Map<String, Object> payload) throws JSONException {
        JSONObject myResponse = new JSONObject(payload.toString());
        long l = myResponse.getLong("l");
        double rate = myResponse.getDouble("r");
        double r = (rate/12)/100;
        int n = myResponse.getInt("n");
        EIM = l*((r*(Math.pow((1+r), n)))/(Math.pow((1+r),n) - 1));
        return new ResponseEntity<>(new RESTResponse.Success()
                .setStatus(HttpStatus.ACCEPTED.value())
                .setMessage("Accepted!")
                .setData(EIM)
                .build(), HttpStatus.ACCEPTED);
    }
    @RequestMapping(method = RequestMethod.POST, value = "operator2")
    public ResponseEntity<Object> operation2(@RequestBody EmiOperator2Dto emiOperator2Dto) {

        double x = EIM * emiOperator2Dto.getMonth() + emiOperator2Dto.getFee();
        return new ResponseEntity<Object>(new RESTResponse.Success()
                .setStatus(HttpStatus.CREATED.value())
                .setMessage("Success!")
                .setData(new Restdto(x))
                .build(), HttpStatus.OK);
    }
}
