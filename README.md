# 软件构造结课大作业

## 作者
- **wqKang**
- **联系方式：** [wenqiaokang@outlook.com](mailto:wenqiaokang@outlook.com)
- **大学：** NCWU
- **地点：** 中国河南郑州

## 概述
该存储库包含软件构造专业项目的源代码，这是一个用于生成算术问题并促进交互式学习的JavaFX程序。

## 特性
- **生成问题：** 动态创建一组算术问题。
- **保存问题：** 将生成的问题存储在MySQL数据库中。
- **加载问题：** 从数据库中检索并显示问题。
- **检查问题：** 允许用户检查他们的答案并提供准确性报告。

## 先决条件
- 已安装Java开发工具包（JDK）。
- 已设置MySQL数据库，并存在必要的表。

## 入门
### 克隆存储库
```bash
git clone https://github.com/Kangwenqiao/Software-Construction-Major-Project.git
cd Software-Construction-Major-Project
```

### 编译和运行
```bash
javac EquationApplication.java
java EquationApplication
```

### 配置数据库
1. 确保MySQL正在运行。
2. 修改MySQLUtil.java中的MySQL连接详细信息。

## 使用应用程序
按照屏幕上的说明生成、保存、加载和检查算术问题。

## 数据库配置
修改MySQLUtil.java中的MySQL连接详细信息以匹配您的数据库配置。

```java
// MySQLUtil.java
private static final String JDBC_URL = "jdbc:mysql://your-database-host:3306/your-database-name";
private static final String USERNAME = "your-username";
private static final String PASSWORD = "your-password";
```

## 依赖项
该应用程序使用JavaFX进行图形用户界面。

## 许可证
此项目根据MIT许可证进行许可。

## 联系方式
- **姓名：** wqKang
- **电子邮件：** [wenqiaokang@outlook.com](mailto:wenqiaokang@outlook.com)
- 如有疑问或问题，请随时与作者联系。
