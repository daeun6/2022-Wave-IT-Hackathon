package com.mysite.wooju.category;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.mysite.wooju.DataNotFoundException;

@Service
public class CategoryService {

	@Autowired
	private CategoryRepository categoryRepository;

	public List<Category> getCategory() {

		List<Category> menuList = categoryRepository.findAll();
		return menuList;

	}

	public Category getCategory2(Integer id) {
		Optional<Category> category = this.categoryRepository.findById(id);
		if (category.isPresent()) {
			return category.get();
		} else {
			throw new DataNotFoundException("category not found");
		}
	}

}
