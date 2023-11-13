package discrete.simulation.drumtruck.data;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import lombok.AllArgsConstructor;
import lombok.Data;


@Data
public class ResultRow {
    //"CLOCK === LQ(t) === WQ(t) === W(t) === L(t) === LOADQ === WEIGHQ === FEL || BS || BL"
    private IntegerProperty clock;
    private IntegerProperty LQt;
    private IntegerProperty WQt;
    private IntegerProperty Wt;
    private IntegerProperty Lt;
    private StringProperty loadQ;
    private StringProperty weighQ;
    private StringProperty fel;
    private IntegerProperty busyLoaderTime;
    private IntegerProperty busyScalerTime;
    public ResultRow(int clock, int LQt, int WQt, int Wt, int Lt, String loadQ, String weighQ, String fel, int busyLoaderTime, int busyScalerTime) {
        this.clock = new SimpleIntegerProperty(clock);
        this.LQt = new SimpleIntegerProperty(LQt);
        this.WQt = new SimpleIntegerProperty(WQt);
        this.Wt = new SimpleIntegerProperty(Wt);
        this.Lt = new SimpleIntegerProperty(Lt);
        this.loadQ = new SimpleStringProperty(loadQ);
        this.weighQ = new SimpleStringProperty(weighQ);
        this.fel = new SimpleStringProperty(fel);
        this.busyLoaderTime = new SimpleIntegerProperty(busyLoaderTime);
        this.busyScalerTime = new SimpleIntegerProperty(busyScalerTime);
    }
    public int getClock() {
        return clock.get();
    }
    public int getLQt() {
        return LQt.get();
    }

    public int getWQt() {
        return WQt.get();
    }

    public int getWt() {
        return Wt.get();
    }
    public int getLt() {
        return Lt.get();
    }

    public int getBusyLoaderTime() {
        return busyLoaderTime.get();
    }

    public int getBusyScalerTime() {
        return busyScalerTime.get();
    }

    public String getLoadQ() {
        return loadQ.get();
    }
    public String getWeighQ() {
        return weighQ.get();
    }

    public String getFel() {
        return fel.get();
    }

}
