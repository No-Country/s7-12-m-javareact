'use client';
import { Provider } from 'react-redux';
import { store } from '../store/store';

import './globals.css';
import { Header } from '@/components/Header';
import { Footer } from '@/components/Footer';

import { Roboto, Russo_One } from 'next/font/google';

const roboto = Roboto({
  weight: '400',
  subsets: ['latin'],
});

const metadata = {
  title: 'MoveAr',
  description: 'La manera fácil moverse',
};

export default function RootLayout({
  children,
}: {
  children: React.ReactNode;
}) {
  return (
    <html lang="en">
      <body className={roboto.className}>
        <Provider store={store}>
          <Header />
          <div className="relative gradient">{children}</div>
          <Footer />
        </Provider>
      </body>
    </html>
  );
}
