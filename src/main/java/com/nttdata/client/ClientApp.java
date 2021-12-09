package com.nttdata.client;

import java.util.Date;
import java.util.List;
import org.hibernate.Session;
import com.nttdata.persistence.Client;
import com.nttdata.services.ClientServiceI;
import com.nttdata.services.ClientServiceImpl;

public class ClientApp {
	public static void main(String[] args) {
		final Session session = ClientSessionUtil.getSessionFactory().openSession();

		final ClientServiceI clientService = new ClientServiceImpl(session);

		final Client daniel = new Client();
		daniel.setNationalIdentityDocument("39684521A");
		daniel.setClientName("Daniel");
		daniel.setClientFirstSurname("Trujillo");
		daniel.setClientSecondSurname("Trasmonte");
		daniel.setUpdatedDate(new Date());
		daniel.setUpdatedUser("scarnero.nttdata");
		clientService.addClient(daniel);

		final Client ana = new Client();
		ana.setNationalIdentityDocument("34127534A");
		ana.setClientName("Ana");
		ana.setClientFirstSurname("Trujillo");
		ana.setClientSecondSurname("Trasmonte");
		ana.setUpdatedDate(new Date());
		ana.setUpdatedUser("scarnero.nttdata");
		clientService.addClient(ana);

		final Client victoria = new Client();
		victoria.setNationalIdentityDocument("32156321A");
		victoria.setClientName("Victoria");
		victoria.setClientFirstSurname("Trujillo");
		victoria.setClientSecondSurname("Trasmonte");
		victoria.setUpdatedDate(new Date());
		victoria.setUpdatedUser("scarnero.nttdata");
		clientService.addClient(victoria);

		final Client searchClient = clientService.findClientById(1L);
		System.out.println(searchClient);

		final List<Client> clienstList = clientService.findAllClientsFromSystem();
		if (clienstList != null && clienstList.size() > 0) {
			System.out.println("Total clientes: " + clienstList.size());
			for (final Client client : clienstList) {
				System.out.println(client.toString() + "\n");
			}
		}

		session.close();
	}
}