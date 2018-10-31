package online.codetutorial;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ValueChangeEvent;
import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;

@ManagedBean(name="language")
@SessionScoped
public class LanguageBean implements Serializable{

    private static final long serialVersionUID = 1L;

    // current locale
    private String local;

    // list of all available locale
    private static Map<String,Object> locals;
    static{
        locals = new LinkedHashMap<String,Object>();
        locals.put("German", Locale.GERMAN);
        locals.put("English", Locale.ENGLISH); //label, value
    }

    // Standard getters and setters
    public Map<String, Object> getLocalsInMap() {
        return locals;
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    public void changeLocal(String language) {
        FacesContext.getCurrentInstance().getViewRoot().setLocale(new Locale(language));
    }

    public void localeChanged(ValueChangeEvent e){
        String newLocaleValue = e.getNewValue().toString();
        //loops over the available locales
        for (Map.Entry<String, Object> entry : locals.entrySet()) {
            if(entry.getValue().toString().equals(newLocaleValue)){
                //sets the selected locale
                FacesContext.getCurrentInstance()
                        .getViewRoot().setLocale((Locale)entry.getValue());

            }
        }

    }

}