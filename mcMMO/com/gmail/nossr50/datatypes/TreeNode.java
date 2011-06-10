package com.gmail.nossr50.datatypes;

import java.util.ArrayList;

import com.gmail.nossr50.datatypes.PlayerStat;

public class TreeNode {
	TreeNode left = null
	, right = null;
	PlayerStat ps = new PlayerStat();

	public TreeNode(String p, int in) {ps.statVal = in; ps.name = p;}

	public void add (String p, int in) {
		if (in >= ps.statVal)
		{
			if (left == null)
				left = new TreeNode(p,in);
			else
				left.add(p, in);
		}
		else if(in < ps.statVal)
		{
		if (right == null)
			right = new TreeNode(p,in);
		else
			right.add(p, in);
		}
	}
	
	public ArrayList<PlayerStat> inOrder(ArrayList<PlayerStat> a)
	{
		if(left != null)
		a = left.inOrder(a);
	
		a.add(ps);
	
		if(right != null)
		a = right.inOrder(a);
	
		return a;
	}
}
