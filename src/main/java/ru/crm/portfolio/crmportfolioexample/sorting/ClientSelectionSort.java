package ru.crm.portfolio.crmportfolioexample.sorting;

import ru.crm.portfolio.crmportfolioexample.exempions.DuplicateRecordException;
import ru.crm.portfolio.crmportfolioexample.models.Client;

import java.util.List;

public class ClientSelectionSort {
    public static void sort(List<Client> clients) {
        for (int i = 0; i < clients.size(); i++) {
            Client min = clients.get(i);
            int min_i = i;
            for (int j = i + 1; j < clients.size(); j++) {
                try {
                    if (clients.get(j).getInn().equals(min.getInn()) &
                            (clients.get(j).getLegalName() == min.getLegalName())) {
                        throw new DuplicateRecordException("Имеется дубликат");
                    }
                    if (clients.get(j).compareTo(min) < 0) {
                        min = clients.get(j);
                        min_i = j;
                    }
                } catch (DuplicateRecordException e) {
                    e.printStackTrace();
                }
            }
            if (i != min_i) {
                Client tmp = clients.get(i);
                clients.set(i, clients.get(min_i));
                clients.set(min_i, tmp);
            }
        }
    }
}
