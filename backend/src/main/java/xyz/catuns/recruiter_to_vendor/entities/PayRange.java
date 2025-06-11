package xyz.catuns.recruiter_to_vendor.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "pay_ranges")
public class PayRange {

    @Id
    @GeneratedValue
    private Long id;

    private Long mininmum = 0L;
    private Long maximum = 0L;

    public Long getId() {
        return id;
    }

    public Long getMininmum() {
        return mininmum;
    }

    public void setMininmum(Long mininmum) {
        if (mininmum > 0) {
            this.mininmum = mininmum;
        }
    }

    public Long getMaximum() {
        return maximum;
    }

    public void setMaximum(Long maximum) {

        this.maximum = maximum;
    }

    @Override
    public String toString() {
        return "PayRange{" +
                "id=" + id +
                ", mininmum=" + mininmum +
                ", maximum=" + maximum +
                '}';
    }
}

