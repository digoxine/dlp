#include <stdio.h>
#include <stdlib.h>
#include "ilp.h"

/* Global variables */
ILP_Object print;

/* Global prototypes */

/* Global functions */


ILP_Object
ilp_program ()
{
  {
    ILP_Object ilptmp623;
    {
      ILP_Object ilptmp624;
      ilptmp624 = ILP_String2ILP ("Un, ");
      ilptmp623 = ILP_print (ilptmp624);
    }
    {
      ILP_Object ilptmp625;
      ilptmp625 = ILP_String2ILP ("deux et ");
      ilptmp623 = ILP_print (ilptmp625);
    }
    {
      ILP_Object ilptmp626;
      ilptmp626 = ILP_String2ILP ("trois.");
      ilptmp623 = ILP_print (ilptmp626);
    }
    return ilptmp623;
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
