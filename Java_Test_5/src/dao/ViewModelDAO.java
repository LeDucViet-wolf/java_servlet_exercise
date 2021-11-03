package dao;

import java.util.List;

import entity.ViewModel;

public interface ViewModelDAO {
	public List<ViewModel> getListViewModel();
	public List<ViewModel> SearchByName(String name);
	public List<ViewModel> SearchById(int id);
}
