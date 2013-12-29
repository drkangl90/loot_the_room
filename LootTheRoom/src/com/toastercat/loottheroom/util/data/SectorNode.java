package com.toastercat.loottheroom.util.data;

import java.util.ArrayList;

public abstract class SectorNode<Type>
{
	public abstract boolean isEmpty();
	public abstract Type find(Type elem);
	public abstract ArrayList<Type> find();
	public abstract SectorNode<Type> insert(Type elem);
	public abstract SectorNode<Type> delete(Type elem);
	public abstract String toString();
}
