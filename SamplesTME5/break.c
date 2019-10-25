#include <stdio.h>
#include <stdlib.h>
#include "ilp.h"

/* Global variables */

/* Global prototypes */

/* Global functions */


ILP_Object
ilp_program ()
{
  {
    ILP_Object ilptmp1;
    ilptmp1 = ILP_Integer2ILP (0);

    {
      ILP_Object i1 = ilptmp1;
      {
	ILP_Object ilptmp2;
	while (1)
	  {
	    ILP_Object ilptmp3;
	    {
	      ILP_Object ilptmp4;
	      ILP_Object ilptmp5;
	      ilptmp4 = i1;
	      ilptmp5 = ILP_Integer2ILP (5);
	      ilptmp3 = ILP_LessThan (ilptmp4, ilptmp5);
	    }
	    if (ILP_isEquivalentToTrue (ilptmp3))
	      {
		{
		  ILP_Object ilptmp6;
		  {
		    ILP_Object ilptmp7;
		    {
		      ILP_Object ilptmp8;
		      ILP_Object ilptmp9;
		      ilptmp8 = i1;
		      ilptmp9 = ILP_Integer2ILP (2);
		      ilptmp7 = ILP_Equal (ilptmp8, ilptmp9);
		    }
		    if (ILP_isEquivalentToTrue (ilptmp7))
		      {
			break;

		      }
		    else
		      {
			ilptmp6 = ILP_FALSE;

		      }
		  }
		  {
		    ILP_Object ilptmp10;
		    {
		      ILP_Object ilptmp11;
		      ILP_Object ilptmp12;
		      ilptmp11 = i1;
		      ilptmp12 = ILP_Integer2ILP (1);
		      ilptmp10 = ILP_Plus (ilptmp11, ilptmp12);
		    }
		    ilptmp6 = (i1 = ilptmp10);
		  }
		  (void) ilptmp6;
		}

	      }
	    else
	      {
		break;

	      }
	  }
	ilptmp2 = ILP_FALSE;
	ilptmp2 = i1;
	return ilptmp2;
      }

    }
  }

}

static ILP_Object
ilp_caught_program ()
{
  struct ILP_catcher *current_catcher = ILP_current_catcher;
  struct ILP_catcher new_catcher;

  if (0 == setjmp (new_catcher._jmp_buf))
    {
      ILP_establish_catcher (&new_catcher);
      return ilp_program ();
    };
  return ILP_current_exception;
}

int
main (int argc, char *argv[])
{
  ILP_START_GC;
  ILP_print (ilp_caught_program ());
  ILP_newline ();
  return EXIT_SUCCESS;
}