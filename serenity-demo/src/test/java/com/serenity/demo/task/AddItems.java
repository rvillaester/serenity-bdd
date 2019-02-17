package com.serenity.demo.task;

import java.util.List;

import com.google.common.collect.ImmutableList;
import com.serenity.demo.ui.TodoPage;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.actions.Open;
import net.thucydides.core.annotations.Step;

public class AddItems implements Performable {

    List<String> thingsToDo;
    TodoPage todoPage;

    @Step("{0} adds #thingsToDo to the todo list")
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Open.browserOn().the(todoPage));
        thingsToDo.forEach(thingToDo -> actor.attemptsTo(AddTodoItem.called(thingToDo)));
    }

    public AddItems called(List<String> thingsToDo) {
        this.thingsToDo = thingsToDo;
        return this;
    }

    public AddItems called(String... thingsToDo) {
        return called(ImmutableList.copyOf(thingsToDo));
    }
}
