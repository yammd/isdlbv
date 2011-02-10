/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package project.misc;

import java.util.ArrayList;

/**
 *
 * @author mad
 * adaptation for the source: http://www.javaprogrammingforums.com/java-code-snippets-tutorials/696-multi-dimension-arraylist-example.html
 */

public class ArrayList2d<Type>
{
    ArrayList<ArrayList<Type>>  array;

    public ArrayList2d()
    {
        array = new ArrayList<ArrayList<Type>>();
    }

    /**
     * ensures a minimum capacity of num rows. Note that this does not guarantee
     * that there are that many rows.
     *
     * @param num
     */
    public void ensureCapacity(int num)
    {
        array.ensureCapacity(num);
    }

    /**
     * Ensures that the given indice row/column exists, if not
     * creating intermediate row(s) and column(s)' cells and
     * fill them in with the Null value
     * 
     * @param row
     * @param column
     */
    public void ensureCapacity(int row, int column)
    {
        /* Ensure the number of row is correct */
        ensureCapacity(row);
        //while (row > getNumRows())
        for(int i=this.getNumRows();i<row+1;i++)
        {
            array.add(new ArrayList<Type>());
        }

        /* Ensure the number of column is correct for all rows */
        for(int i=0;i<this.getNumRows();i++)
        {
            ArrayList a=array.get(i);
            a.ensureCapacity(column);
            for(int j=a.size();j<column+1;j++)
                a.add(null);
            
        }
    }

    /**
     * Adds an item at the end of the specified row. This will guarantee that at least row rows exist.
     */
    public void add(Type data, int row, int column)
    {
        this.ensureCapacity(row,column);

        array.get(row).set(column, data);
    }

    public Type get(int row, int col)
    {
        return array.get(row).get(col);
    }

    public void set(int row, int col, Type data)
    {
        array.get(row).set(col,data);
    }

    /* TODO, cleaner version of remove */
    public void remove(int row, int col)
    {
        array.get(row).remove(col);
    }

    public boolean contains(Type data)
    {
        for (int i = 0; i < array.size(); i++)
        {
            if (array.get(i).contains(data))
            {
                return true;
            }
        }
        return false;
    }

    public int getNumRows()
    {
        return array.size();
    }

    public int getNumCols(int row)
    {
        return array.get(row).size();
    }

    public void print()
    {
        for (int i=0;i<this.getNumRows();i++)
        {
            for(int j=0;j<this.getNumCols(i);j++)
                System.out.print(this.get(i, j)+" ");
            System.out.println("\n");
        }
    }
}
