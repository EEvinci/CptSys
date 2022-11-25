## 登录功能设计:

- `model`包`User`表属性定义

  ![image-20220829103322359](http://evinci.oss-cn-hangzhou.aliyuncs.com/evinci/image-20220829103322359.png)

- `Dao`包`UserDao`依据用户名和密码`查询用户` 登录信息管理

  ![image-20220829103201782](http://evinci.oss-cn-hangzhou.aliyuncs.com/evinci/image-20220829103201782.png)

- `view`包`LogOnFrm`登录`验证用户名密码匹配`功能设计

  ![image-20220829102244143](http://evinci.oss-cn-hangzhou.aliyuncs.com/evinci/image-20220829102244143.png)



边框设置代码

```java
bookTypeDescTxt.setBorder(new LineBorder(new java.awt.Color(127,157,185),1,false));
```

```java

private DBUtil dbUtil = new DBUtil();
private CptDap cptDao = new CptDao();

CptItemAddActionPerformed(e);
/**
 *  赛项添加事件
 * @param e
 */
	private void CptItemAddActionPerformed(ActionEvent evt) {
		// TODO 自动生成的方法存根
		String cptItemId = this.CptItemIdTxt.getText();
		String cptItemName = this.CptItemName.getText();
		String resPerson = this.ResPersonTxt.getText();
		String belongCol = this.BelongCol.getText();
		String cptLevel = this.CptLevel.getText();
		if(StringUtil.isEmpty(cptItemId) || StringUtil.isEmpty(cptItemName) || StringUtil.isEmpty(resPerson) 
				|| StringUtil.isEmpty(belongCol) || StringUtil.isEmpty(cptLevel)){
			JOptionPane.showMessageDialog(null, "请将赛项信息填写完整");
			return;
		}
		BeanCptItemInfo cptItemInfo = new BeanCptItemInfo(cptItemId,cptItemName,resPerson,belongCol,cptLevel);
		Connection conn = null;
		try{
			conn = dbUtil.getConn();
			int n = cptItemDao.add(conn,cptItemInfo);
			if(n == 1) {
				JOptionPane.showMessageDialog(null, "赛项信息添加成功");
			}
			else {
				JOptionPane.showMessageDialog(null, "赛项信息添加失败");
			}
		}catch(Exception e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "赛项信息添加失败");
		}finally {
			try {
				dbUtil.closeConn(conn);
			}
			catch(Exception e) {
				e.printStackTrace();
			}
		}
	}


	resetValueActionPerformed(e);
/**
 * 重置函数
 * @param evt
 * 
 */
	private void resetValueActionPerformed(ActionEvent evt) {
		this.CptItemIdTxt.setText("");
		this.CptItemName.setText("");
		this.ResPersonTxt.setText("");
		this.BelongCol.setText("");
		this.CptLevel.setText("");
	}


    
```

不同包的代码分类:

- Dao包中是数据操作
- Util中是业务逻辑（login，重复）
- 在Dao中尽可能地减少检查， 只做必要的和数据库相关的检查，因为业务逻辑是会频繁变化的，所以不同的代码应该写在不同的包中，以后方便做修改



java命名习惯：

- 包名应该全部是小写
- 类名应该全部是大写
- 方法名里面不应该有`下划线_`(C语言的命名习惯)
- 方法名的第一个字母应该小写, 然后后面单词的第一个首字母大写



数据库表命名习惯:

- 数据库表名都是小写的, 所以单词之间用下划线分开, java中的model类写表名时每个单词的首字母都大写

- 数据库表中的`属性命名`没有必要在前面添加`前缀词`用来辨别

  比如学生和老师的表中都有Name, 没有必要在老师表中写teacher_name, 学生表中写stu_name, 每个表中只写name即可, 因为在引用的时候会谢stu.name, 会在前面加上引用



数据库的设计要比较的清楚, 数据库的设计是一件比较精细的事情

每一列的作用, 每一个字段和每一个字段的关系



**疑问1：**

![image-20220906215104206](http://evinci.oss-cn-hangzhou.aliyuncs.com/evinci/image-20220906215104206.png)

像这种要删除主键，但是外键存在的情况，是否可以用catch捕捉到的异常作为另一种情况的判断

这种情况出现是一种非法操作，但是由于try-catch将错误捕捉了下来，同时保证程序还能正常进行，利用这个向用户抛出提示信息，作为一种情况的处理

但是这种情况的处理方式是来自于捕捉错误信息，是一种以错治错的方式



