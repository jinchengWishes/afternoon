package wang.lijinchen.ui;

import lombok.Data;

import javax.swing.*;
import java.awt.*;

/**
 * @ClassName: MyJPanel
 * @Description:
 * @Author: jincheng
 * @Date: 2021/3/17 21:02
 */
@Data
public class MyJPanel extends JPanel {

    private ImageIcon icon;

    public MyJPanel(Integer x, Integer y, Integer width, Integer height,String iconPath) {
        this.setBounds(x, y, width, height); //x坐标10，y坐标0，组件宽100，高50
        this.icon = new ImageIcon(iconPath);
    }

    public void paintComponent(Graphics g) {
        int x = 0, y = 0;
//        g.drawImage(icon.getImage(), x, y, getSize().width,
//                getSize().height, this);// 图片会自动缩放
        g.drawImage(icon.getImage(), x, y, this);//图片不会自动缩放
    }

}
