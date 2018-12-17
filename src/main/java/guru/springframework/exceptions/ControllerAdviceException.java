package guru.springframework.exceptions;


import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

@Slf4j
@ControllerAdvice
public class ControllerAdviceException {

    private ModelAndView createViewModel(Exception ex, String viewName) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName(viewName);
        modelAndView.addObject("exception", ex);
        return modelAndView;
    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(NotFoundResultException.class)
    public ModelAndView notFound(Exception ex) {
        log.error("Not found result {}", ex.getMessage());

        ModelAndView modelAndView = createViewModel(ex, "404");

        return modelAndView;
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(NumberFormatException.class)
    public ModelAndView badRequest(Exception ex) {
        log.error("The parameter informed does not number", ex.getMessage());

        ModelAndView modelAndView = createViewModel(ex, "400");

        return modelAndView;
    }
}
