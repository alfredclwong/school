## Copyright (C) 2014 Alfred CL Wong
## 
## This program is free software; you can redistribute it and/or modify it
## under the terms of the GNU General Public License as published by
## the Free Software Foundation; either version 3 of the License, or
## (at your option) any later version.
## 
## This program is distributed in the hope that it will be useful,
## but WITHOUT ANY WARRANTY; without even the implied warranty of
## MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
## GNU General Public License for more details.
## 
## You should have received a copy of the GNU General Public License
## along with this program.  If not, see <http://www.gnu.org/licenses/>.

## -*- texinfo -*- 
## @deftypefn {Function File} analysedata (@var{x}, @var{y})
## High level interactive tool to assist in analysing experimental data. It can:
##
## @table @samp
## @item 1
## Load and plot several datasets onto the same graph in different colours
##
## @item 2
## Fit and plot a polynomial for a given dataset
##
## @item 3
## Find the area under the curve of a given polynomial between two bounds
##
## @item 4
## Find the area between two curves of given polynomials between two bounds
##
## @item 5
## Identify linear regions within a given dataset and find the gradient of the
## line passing through these data points (e.g. for finding Young's Modulus)
##
## @item 6
## Serve breakfast in bed.
## @seealso{}
## @end deftypefn

## Author:  Alfred CL Wong <alfred.cl.wong@gmail.com>
## Created: 17-10-2014

function analysedata()

  ## Return to the main menu forever until the quit option is chosen
  while(1)
    ## Take a user input from the main menu
    switch(menu('*** MAIN MENU ***',                                         ...
        'Load and plot a new dataset',                                       ...
        'Fit and plot a polynomial for a loaded dataset',                    ...
        'Find the area under the curve of a plotted polynomial',             ...
        'Find the area between two curves of plotted polynomials',           ...
        'Find the gradients of linear regions within a loaded dataset',      ...
        'Exit analysedata',                                                  ...
        'Quit Octave/MATLAB'                                                 ...
        ))
      case 1
        ## Load and plot dataset
        
      case 2
        ## Fit polynomial

      case 3
        ## Area under curve

      case 4
        ## Area between two curves

      case 5
        ## Gradients of linear regions

      case 6
        return;
      case 7
        exit();
      otherwise
        disp('Something went really wrong');
        exit();
    endswitch
    disp('Returning to main menu....');
  endwhile

endfunction
