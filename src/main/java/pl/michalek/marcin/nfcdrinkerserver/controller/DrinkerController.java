package pl.michalek.marcin.nfcdrinkerserver.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import pl.michalek.marcin.nfcdrinkerserver.model.Drinker;
import pl.michalek.marcin.nfcdrinkerserver.model.DrinkingParameters;
import org.springframework.web.bind.annotation.*;
import pl.michalek.marcin.nfcdrinkerserver.utils.Util;

import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by Marcin on 2015-01-02.
 */
@RestController
@RequestMapping(value = "/")
public class DrinkerController {
    private List<Drinker> currentDrinkers = new ArrayList<Drinker>();
    private boolean listChanged = false;

    @RequestMapping(value = "drink", method = RequestMethod.POST)
    @ResponseBody
    public boolean saveDrinker(@RequestBody Drinker drinker) {
        listChanged = true;

        if (currentDrinkers.contains(drinker)) {
            Drinker theDrinker = Util.getDrinkerFromList(currentDrinkers, drinker);
            if (theDrinker != null) {
                theDrinker.getDrinkingParameters().increaseRounds();
                theDrinker.calculateCurrentPromilsSimpleMethod();
            }
        } else {
            DrinkingParameters drinkingParameters = new DrinkingParameters();
            drinkingParameters.increaseRounds();
            drinker.setDrinkingParameters(drinkingParameters);
            drinker.calculateCurrentPromilsSimpleMethod();
            currentDrinkers.add(drinker);
        }

        Collections.sort(currentDrinkers);
        return true;
    }

    @RequestMapping(value = "listDrinkers")
    @ResponseBody
    public List<Drinker> listDrinkers() {
        return currentDrinkers;
    }

    @RequestMapping("alertTest")
    public
    @ResponseBody
    String sendMessage(HttpServletResponse response) throws JsonProcessingException {
        if (!listChanged) {
            response.setContentType("text/event-stream");
            return "event:not_changed\n" + "data:none" + "\n\n";
        } else {
            listChanged = false;
            response.setContentType("text/event-stream");
            return "event:changed\n" + "data:" + new ObjectMapper().writeValueAsString(currentDrinkers) + "\n\n";
        }
    }
}
