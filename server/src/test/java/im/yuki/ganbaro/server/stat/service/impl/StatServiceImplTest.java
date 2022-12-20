package im.yuki.ganbaro.server.stat.service.impl;

import org.junit.Test;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Calendar;

import static org.junit.Assert.*;

/**
 * @author longkun
 * @version V1.1.0
 * @date 2022/12/20 11:46 PM
 * @description
 */
public class StatServiceImplTest {

    @Test
    public void queryCheckIn() {
        Calendar calendar = Calendar.getInstance();
        System.out.println(calendar.get(Calendar.MONTH));

        int dayOfYear = calendar.get(Calendar.DAY_OF_YEAR);
        int lengthOfYear = LocalDate.of(2022, 1, 1).lengthOfYear();
        String passOfYear = new BigDecimal(dayOfYear)
                .divide(new BigDecimal(lengthOfYear), 4, BigDecimal.ROUND_HALF_UP)
                .multiply(BigDecimal.valueOf(100))
                .setScale(2, BigDecimal.ROUND_HALF_UP)
                + " %";

        System.out.println(passOfYear);
    }
}
