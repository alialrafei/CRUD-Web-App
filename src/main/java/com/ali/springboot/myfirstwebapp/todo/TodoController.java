package com.ali.springboot.myfirstwebapp.todo;

import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import jakarta.validation.Valid;


@Controller
@SessionAttributes("name")
public class TodoController {
    //Url List-todos
    private TodoService todoService;
    
    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }

    @RequestMapping("list-todos")
    public String listAllTodos( ModelMap model){
        List<Todo> todos = todoService.findByUserName("ali");
        model.put("todos", todos);
        return "listTodos";
    }
    @RequestMapping(value = "add-todo",method = RequestMethod.GET)
    public String showNewTodoPage(ModelMap model){
        //bind this todo object to the form tags and by adding it to the model so we the requested page is loaded it will get the model with the mapped objects inside it 
        Todo todo = new Todo(0, (String)model.get("name"), "",  LocalDate.now().plusYears(1), false);
        // the key is the modelAttribute we added in the front end 
        model.put("todo",todo);
        return "Todo";
    }
    
    // bind directly to the bean 
    //adding Validation to the bean 
    // bind the error to redirect to todo if an error occures 
    @RequestMapping(value = "add-todo",method = RequestMethod.POST)
    public String addNewTodoItem(ModelMap model,@Valid  Todo todo,BindingResult result){
        
        if(result.hasErrors()){
            return "Todo";
        }
        String username = (String)model.get("name");
        todoService.addTodo(username, todo.getDescription(), LocalDate.now().plusYears(1), false);
        return "redirect:list-todos";
    }

    @RequestMapping(value = "delete-todo",method = RequestMethod.GET)
    public String deleteTodoItem(@RequestParam int id ,ModelMap model){
        
        todoService.deleteTodo(id);
        return "redirect:list-todos";
    }
}
