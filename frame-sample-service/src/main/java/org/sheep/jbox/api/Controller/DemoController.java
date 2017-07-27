package org.sheep.jbox.api.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Joseph on 2017/6/29.
 */
@RestController
public class DemoController {

    @RequestMapping(value = "helloword1", method = RequestMethod.GET)
    public String helloword1() {
        return "abc";
    }

    @GetMapping("helloword2")
    public String helloword2() {
        return "cba";
    }
}
