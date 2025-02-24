package org.example;

public class Main
{

	public static void main(String[] args)
	{
		if (args.length > 0 && Integer.parseInt(args[0]) > 0)
			System.out.println("positive");
		else
			System.out.println("negative");
	}
}
