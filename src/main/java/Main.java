import org.apache.log4j.BasicConfigurator;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.Velocity;
import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;

import java.io.StringWriter;
import java.util.HashMap;
import java.util.Map;

import static spark.Spark.get;

public class Main {
    public static void main(String[] args) {
        BasicConfigurator.configure();
//        String message = "Hello,";
//        User user = new User("Radek");
//        Velocity.init();
//        VelocityContext velocityContext = new VelocityContext();
//        StringWriter writer = new StringWriter();
//
//        velocityContext.put("user",user);
//        velocityContext.put("welcome", message);
//        Velocity.mergeTemplate("src/main/myTemplate.html",velocityContext,writer);
//        System.out.println(writer);
        // do this
        get("template-example", (req, res) -> {
            String templateVariable = "Jestę programistę";
            Map<String, Object> model = new HashMap<>();
            model.put("message",templateVariable);

            return new VelocityTemplateEngine().render(
                    new ModelAndView(model, "hello.vm")
            );
        });
    }
}
