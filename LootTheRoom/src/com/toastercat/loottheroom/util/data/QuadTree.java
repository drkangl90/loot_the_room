package com.toastercat.loottheroom.util.data;

import java.util.ArrayList;

public abstract class QuadTree<Type>
{
	public abstract boolean insert(Type elem);
	public abstract boolean delete(Type elem);
	public abstract Type find(Type elem);
	public abstract ArrayList<Type> find();
	public abstract String toString();
}
