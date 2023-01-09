import { Disclosure } from "@headlessui/react";
import { Bars3Icon, XMarkIcon } from "@heroicons/react/24/outline";
import { Link } from "react-router-dom";
import Pict from "../../Assets/PrimaryLogo.png";

function Navbar() {
  const navigation = [
    { name: "Home", href: "/", current: false },
    { name: "Tentang Kami", href: "/about-us", current: false },
    { name: "Registrasi", href: "/form", current: false },
  ];

  function classNames(...classes) {
    return classes.filter(Boolean).join(" ");
  }
  return (
    <Disclosure as="nav" className="bg-white">
      {({ open }) => (
        <>
          <div className="min-w-7xl mx-auto border-b border-gray-50 bg-white px-2 sm:px-6 lg:px-8">
            <div className="relative mx-0 flex h-16 items-center justify-between md:mx-20">
              <div className="absolute inset-y-0 left-0 flex items-center sm:hidden">
                {/* Mobile menu button*/}
                <Disclosure.Button className="inline-flex items-center justify-center rounded-md p-2 text-gray-400 hover:bg-indigo-400 hover:text-white focus:outline-none focus:ring-2 focus:ring-inset focus:ring-white">
                  <span className="sr-only">Open main menu</span>
                  {open ? (
                    <XMarkIcon className="block h-6 w-6" aria-hidden="true" />
                  ) : (
                    <Bars3Icon className="block h-6 w-6" aria-hidden="true" />
                  )}
                </Disclosure.Button>
              </div>
              <div className="flex flex-1 items-center justify-center sm:items-stretch sm:justify-start">
                <div className="flex flex-shrink-0 items-center ">
                  <img
                    src={Pict}
                    width={40}
                    height={40}
                    objectfit="contain"
                    alt="Logo"
                    className="xl:mx-8 sm:ml-6"
                  ></img>
                </div>
                <div className="hidden sm:ml-6 sm:block md:ml-60">
                  <div className="flex space-x-4">
                    {navigation.map((item) => (
                      <Link
                        key={item.name}
                        to={item.href}
                        className={classNames(
                          item.current
                            ? "bg-indigo-800 text-white shadow-lg"
                            : "text-gray-300 hover:bg-indigo-400 hover:text-white hover:shadow-lg",
                          "rounded-md px-3 py-2 text-sm font-medium"
                        )}
                        aria-current={item.current ? "page" : undefined}
                      >
                        {item.name}
                      </Link>
                    ))}
                  </div>
                </div>
              </div>
            </div>
          </div>
          <Disclosure.Panel className="sm:hidden">
            <div className="space-y-1 px-2 pt-2 pb-3">
              {navigation.map((item) => (
                <Disclosure.Button
                  key={item.name}
                  className={classNames(
                    item.current
                      ? "bg-indigo-800 text-white shadow-lg"
                      : "text-gray-300 hover:bg-indigo-400 hover:text-white hover:shadow-lg",
                    "block rounded-md px-3 py-2 text-base font-medium"
                  )}
                  aria-current={item.current ? "page" : undefined}
                >
                  <Link to={item.href}>{item.name}</Link>
                </Disclosure.Button>
              ))}
            </div>
          </Disclosure.Panel>
        </>
      )}
    </Disclosure>
  );
}
export default Navbar;
