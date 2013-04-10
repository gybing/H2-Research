package my.test.expression;

import my.test.TestBase;

public class ExpressionTest extends TestBase {
	public static void main(String[] args) throws Exception {
		new ExpressionTest().start();
	}

	//����org.h2.command.Parser.readCondition()
	@Override
	public void startInternal() throws Exception {
		stmt.executeUpdate("create table IF NOT EXISTS mytable(id int primary key, name varchar(500))");

		//stmt.executeUpdate("SET @topVariableName=3");
		//stmt.executeUpdate("delete top @topVariableName from mytable where id>10");
		//stmt.executeUpdate("delete top 3 from mytable where id>10");
		//stmt.executeUpdate("delete top ?1 from mytable where id>10");

		//stmt.executeUpdate("delete top true from mytable where id>10");
		//stmt.executeUpdate("update mytable set name='1234567890' where id>10");
		//stmt.executeUpdate("delete top rownum from mytable where id>10");
		//stmt.executeUpdate("delete top CURRENT_TIME from mytable where id>10");
		//stmt.executeUpdate("delete top MAX(id) from mytable where id>10");

		//stmt.executeUpdate("select MAX(id) from mytable where id>10");

		//ps =conn.prepareStatement("delete top ?2 from mytable where id>10");

		//		PreparedStatement ps =conn.prepareStatement("delete top ?2 from mytable where id>10 and name=?1");
		//		ps.setString(1, "abcdef1234");
		//		ps.setInt(2, 3);
		//		ps.executeUpdate();

		//����2��SQL����org.h2.command.Parser.readCondition()�е�NOT��EXISTS
		//stmt.executeUpdate("delete from mytable where not (id>0)");
		//stmt.executeUpdate("delete from mytable where EXISTS (select id from mytable where id>10)");

		//����5��SQL����org.h2.command.Parser.readConcat()��5�����
		//stmt.executeUpdate("delete from mytable where name='aaa' || 'bbb' || 'ccc'");
		//stmt.executeUpdate("delete from mytable where name~'aaa'");
		//stmt.executeUpdate("delete from mytable where name~*'aaa'");
		//stmt.executeUpdate("delete from mytable where name!~'aaa'");
		//stmt.executeUpdate("delete from mytable where name!~*'aaa'");

		stmt.executeUpdate("delete from mytable where name not null"); //�������Ϸ�
		//stmt.executeUpdate("delete from mytable where name is null"); //�����źϷ�

		//stmt.executeUpdate("delete from mytable where name like 'abc' ESCAPE 'bcd'"); //ESCAPEֻ����һ���ַ�
		//stmt.executeUpdate("delete from mytable where name like 'abc' ESCAPE 'b'");
		//stmt.executeUpdate("delete from mytable where name REGEXP 'b-'");

		//		stmt.executeUpdate("delete from mytable where name is not null");
		//		stmt.executeUpdate("delete from mytable where name is not DISTINCT FROM 'abc'");
		//		stmt.executeUpdate("delete from mytable where name is not 'abc'");

		//		stmt.executeUpdate("delete from mytable where name is null");
		//		stmt.executeUpdate("delete from mytable where name is DISTINCT FROM 'abc'");
		//		stmt.executeUpdate("delete from mytable where name is 'abc'");

		//stmt.executeUpdate("delete from mytable where name in()");
		//		stmt.executeUpdate("delete from mytable where name in(select name from mytable where id>10)");
		//		stmt.executeUpdate("delete from mytable where id in(1,2,4)");

		//stmt.executeUpdate("delete from mytable where id BETWEEN 1 AND 2");

		stmt.executeUpdate("delete from mytable where id > ALL(select id from mytable where id>10)");
		//ANY��SOMEһ��
		stmt.executeUpdate("delete from mytable where id > ANY(select id from mytable where id>10)");
		stmt.executeUpdate("delete from mytable where id > SOME(select id from mytable where id>10)");
		//stmt.executeUpdate("delete from mytable where id > 10 (+) id > 10");
		//stmt.executeUpdate("delete from mytable where id > id (+)");
		stmt.executeUpdate("delete from mytable where id > 10");

		for (int i = 1; i <= 200; i++) {
			stmt.executeUpdate("insert into mytable(id, name) values(" + i + ", 'abcdef1234')");
		}

	}

}