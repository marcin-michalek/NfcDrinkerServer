package application;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class AlcoholKindController {
    String[] alcohols = {"VODKA", "BEER", "TEQUILA", "RUM"};

    @RequestMapping(value = "/alcoholKind")
    @ResponseBody
    public String[] listAlcohols() {
        return alcohols;
    }
}
