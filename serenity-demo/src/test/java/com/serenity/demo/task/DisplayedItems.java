package com.serenity.demo.task;

import java.util.List;
import java.util.stream.Collectors;

import com.serenity.demo.ui.ToDoList;

import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;

public class DisplayedItems implements Question<List<String>> {

    public static DisplayedItems theDisplayedItems() {
        return new DisplayedItems();
    }

    @Override
    public List<String> answeredBy(Actor actor) {
        return BrowseTheWeb.as(actor).findAll(ToDoList.TODO_ITEMS).stream()
                                     .map(WebElementFacade::getText)
                                     .collect(Collectors.toList());
    }
}
