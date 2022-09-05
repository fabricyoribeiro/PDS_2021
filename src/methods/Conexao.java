//package connection;
//
//public class Connection{
//	
//	//Necessita o driver disponível no site do postgres. ->Link compartilhado no discord.
//	public Connection Conectar(){
//		Connection con = null;
//		try{
//			Class.forName('org.postgresql.Driver');
//			//jdbc:postgresql://localhost:5432/nomeDaTabela','usuário','senha'
//			conn = DriverManager.getConnection('jdbc:postgresql://localhost:5432/clientes','postgres','admin');
//		}catch(ClassNotFoundException exception){
//			exception.printStackTrace();
//		}catch(SQLException e){
//			e.printStackTrace();
//		}
//	}
//	
//	public void Desconectar(Connection connection){
//		try{
//			if(connection){
//				connection.close();
//			}
//		}catch(SQLException exception){
//			exception.printStackTrace();
//		}
//	}
//	
//	
//	//Alterar para Boolean
//	//Atualizar todos os parâmetros
//	public void adicionarCliente(Cliente novoClientem){
//		Connection conn = Conectar();
//		try{
//			String insert = 'insert into clientes(nome,cpf,rg,telefone) values (?,?,?,?)';
//			PreparedStatement stm =  conn.prepareStatement(insert);
//			stm.setString(1, novoCliente.getNome());
//			stm.setString(2, novoCliente.getCpf());
//			stm.setString(3, novoCliente.getRg());
//			stm.setString(4, novoCliente.getTelefone());
//		}
//		catch(SQLException exception){
//			exception.printStackTrace();
//		}
//		Desconectar(conn);
//		
//	}	
//	
//	
//	
//	public ResultSet consultarTodosClientes(){
//		ResultSet res = null;
//		Connection conn = Connectar();
//		
//		try{
//			String sql_consulta = 'select * from clientes order by id';
//			PreparedStatement pstm = conn.prepareStatement(sql_consulta);
//			res = pstm.executeQuery();
//		}
//		catch(SQLException e){
//			e.printStackTrace();
//		}
//		finally{
//			Desconectar(conn);
//		}
//		return res;
//	}
//
//	public ResultSet ConsultarCliente(int id){
//		ResultSet res = null;
//		Connection conn = Conectar();
//		try{
//			String sql_consulta = 'select * from clientes where id =' + id;
//			PreparedStatement pstm = conn.prepareStatement(sql_consulta);
//			res = pstm.executeQuery();
//			}
//			catch (SQLException){
//				e.printStackTrace();
//			}
//			finally{
//				Desconectar(conn);
//			}
//			return res;
//	}
//	
//	//Alterar para Boolean na 3° Sprint
//	public void ExcluirCliente(int id){
//		Connection conn = Conectar();
//		try{
//			String excluir = 'delete from clientes where id=' + id;
//			PreparedStatement pstm = conn.prepareStatement(sql_consulta);
//			res = pstm.executeQuery();
//		}catch (SQLException){
//				e.printStackTrace();
//			}
//			finally{
//				Desconectar(conn);
//			}
//	}
//
//	
//	public void EditarCliente(Cliente cliente, int id){
//		Connection conn = Conectar();
//		try{
//			String sql-editar='update clientes set nome = ? cpf = ? rg = ? telefone = ? where id=' + id;
//			PreparedStatement stm = conn.prepareStatement(sql-editar);
//			stm.setString(1, cliente.getNome());
//			stm.setString(2, cliente.getCpf());
//			stm.setString(3, cliente.getRg());
//			stm.setString(4, cliente.getTelefone());
//		}
//		catch(SQLException exception){
//			exception.printStackTrace();
//		}
//		finally{
//			Desconectar(conn); 
//		}
//}
//
