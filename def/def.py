'''
Simple program to request a dictionary definition from
brave
'''
import sys
import requests
from bs4 import BeautifulSoup as beautiful

if __name__ == '__main__':

    args = sys.argv
    if len(args) < 2:
        sys.exit(1)

    try:
        r = requests.get(
            f"https://search.brave.com/search?q=define+{args[1]}&source=web",
            timeout=3)
        if(r.status_code == 429):
            sys.stderr.write("Too many requests: Exiting\n")
            sys.exit(1)

        soup = beautiful(r.text, 'html5lib')

        print(10 * " -- -- ")
        print(soup.find("h6")['class'][1], " ", end="")
        print(soup.find("h6").get_text().strip())

        for tag in soup.find_all(id="rh-definitions"):
            for i,sub in enumerate(tag.findAll("li",text=True)):
                print()

                if i == 0:
                    print(sub.parent.parent.findAll("h6")[0].get_text())
                if not sub.get_text().strip().isspace():
                    print(f"\t {i + 1}-",sub.get_text().strip())

    except requests.exceptions.Timeout:
        sys.stderr.write("\tConnection time out\n")
        print(10 * " -- -- ")        
        sys.exit(1)
    except Exception:
        sys.stderr.write("\t *** Cound not find the definition ")
        sys.exit(1)
        print(10 * " -- -- ")        
    print(10 * " -- -- ")        
                         
