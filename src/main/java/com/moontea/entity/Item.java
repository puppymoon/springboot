package com.moontea.entity;

import java.io.Serializable;
import javax.persistence.*;

import org.hibernate.annotations.GenericGenerator;

/**
 * The persistent class for the BOOK database table.
 * 
 */
@Entity
@Table(name = "item")
public class Item implements Serializable {

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((itemName == null) ? 0 : itemName.hashCode());
		result = prime * result + ((seri == null) ? 0 : seri.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Item other = (Item) obj;
		if (itemName == null) {
			if (other.itemName != null)
				return false;
		} else if (!itemName.equals(other.itemName))
			return false;
		if (seri == null) {
			if (other.seri != null)
				return false;
		} else if (!seri.equals(other.seri))
			return false;
		return true;
	}

	@Id
	@GenericGenerator(name = "custom_generator", strategy = "com.moontea.entity.CustomIdentifierGenerator")
	@GeneratedValue(generator = "custom_generator")
	@Column(name = "SERI")
	private String seri;

	@Column(name = "ITEM_NAME")
	private String itemName;

	public Item() {
	}

	public String getSeri() {
		return seri;
	}

	public void setSeri(String seri) {
		this.seri = seri;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	@Override
	public String toString() {
		return "Item [itemName=" + itemName + ", seri=" + seri + "]";
	}

}