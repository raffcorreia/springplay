INSERT INTO demo.dbo.TB_XSS (ID, [TEXT]) VALUES
(0,'test 1A'),
(1,'those are two BRs;<br><br>'),
(2,'<b onMouseOver=alert(''Mouse_over_test!'')>move mouse here!</b>'),
(3,'<b onClick=alert(''Click_Test!'')>click me</b>'),
(4,'</tb></tr></table><p>test</p>'),
(5,'<script>alert(1);</script>'),
(6,'javascript:alert("Hi there")'),
(7,'this<br>is<p>a</p>test'),
(8,'test 2d"<br>"'),
(9,'<p style="color:blue;font-size:46px;">Style test</p>');

INSERT INTO demo.dbo.TB_XSS (ID, [TEXT]) VALUES
(18,'AAA'),
(19,'BBB'),
(23,'<b onClick=alert(''Click_Test!'')>click me2</b>'),
(26,'BBB5'),
(35,'AAABBBCCC'),
(41,'asfasdfasdfaAAAAAAAAAA');

INSERT INTO demo.dbo.TB_LOGIN (ID,NAME,PASSWORD) VALUES
(0,'test','test'),
(1,'user','user');
