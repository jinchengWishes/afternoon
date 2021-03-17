package wang.lijinchen.ui;

import lombok.Data;

/**
 * @ClassName: MyJPanelEvent
 * @Description:
 * @Author: jincheng
 * @Date: 2021/3/17 21:28
 */
@Data
public class MyJPanelEvent {
    private MyJPanel myJPanel;

    public MyJPanelEvent(MyJPanel myJPanel){
        this.myJPanel = myJPanel;
    }




}
