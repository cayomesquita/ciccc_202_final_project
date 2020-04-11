package ca.ciccc.coronarace.component;
import ca.ciccc.coronarace.Config;
import com.almasb.fxgl.entity.component.Component;

public class MedicineComponent  extends Component {
    public MedicineComponent()                     { super(); }
    @Override public void onAdded()            { super.onAdded(); }
    @Override public void onUpdate(double tpf) {
        super.onUpdate(tpf);
        double speed = (Config.STREET_SPEED) * tpf;
        entity.setY(entity.getY()+speed);
    }
    @Override public void onRemoved()          { super.onRemoved();   }
}
