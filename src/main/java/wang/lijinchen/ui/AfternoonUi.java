package wang.lijinchen.ui;

import lombok.Data;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

/**
 * @ClassName: AfternoonUi
 * @Description:
 * @Author: jincheng
 * @Date: 2021/3/17 20:38
 */
@Data
public class AfternoonUi extends JFrame{
    private static AfternoonUi afternoonUi;
    private Boolean isDraging;
    private Integer xx;
    private Integer yy;
    private Integer diyWidth = 418;
    private Integer diyHeight = 106;

    private MyJPanel vanishJPanel;
    private MyJPanel importJPanel;
    private MyJPanel exitJPanel;
    private MyJPanel settingJPanel;
    private MyJPanel centerJPanel;
    private AfternoonUi(){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//退出
        dispose();
        moveJFrame();
        this.setUndecorated(true);
        this.setLayout(null);//空布局
        this.setBounds(0,0, diyWidth, diyHeight);//窗口出现到位置以及大小
        addJPanel();
        this.setVisible(true);
    }

    public void addJPanel(){
        vanishJPanel = new MyJPanel(0,0,46, 54,"./close.png");
        vanishJPanel.setBackground(Color.BLUE);

        importJPanel = new MyJPanel(0,53,46, 54,null);
        importJPanel.setBackground(Color.BLACK);

        exitJPanel = new MyJPanel(372,0,46, 54,null);
        exitJPanel.setBackground(Color.RED);

        settingJPanel = new MyJPanel(372,54,46, 54,null);
        settingJPanel.setBackground(Color.green);


        centerJPanel = new MyJPanel(46,0,326, diyHeight,null);
        centerJPanel.setBackground(Color.PINK);
        this.add(vanishJPanel);
        this.add(importJPanel);
        this.add(exitJPanel);
        this.add(settingJPanel);
        this.add(centerJPanel);
    }
    public synchronized static AfternoonUi getInstance(){
        if(afternoonUi == null){
            afternoonUi = new AfternoonUi();
        }
        return afternoonUi;
    }
    private void moveJFrame(){
        //实现无边框拖拽界面
        //监听最初位置
        this.addMouseListener(new MouseAdapter() {    //给JFrame窗体添加一个鼠标监听
            public void mousePressed(MouseEvent e) {     //鼠标点击时记录一下初始位置
                isDraging = true;
                xx = e.getX();
                yy = e.getY();
            }
            public void mouseReleased(MouseEvent e) {  //鼠标松开时
                isDraging = false;
            }
        });
        //时刻更新鼠标位置
        this.addMouseMotionListener(new MouseMotionAdapter() { //添加指定的鼠标移动侦听器，以接收发自此组件的鼠标移动事件。如果侦听器 l 为 null，则不会抛                                                         出异常并且不执行动作。
            public void mouseDragged(MouseEvent e) {
                //修改位置
                if (isDraging) {                                //只要鼠标是点击的（isDraging），就时刻更改窗体的位置
                    int left = getLocation().x;
                    int top = getLocation().y;
                    setLocation(left + e.getX() - xx, top + e.getY() - yy);
                }
            }
        });
    }
}
