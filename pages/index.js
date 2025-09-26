import Head from 'next/head'

export default function Home({ serverTime }) {
  return (
    <>
      <Head>
        <title>MB TopoFlow AI</title>
        <meta name="viewport" content="width=device-width, initial-scale=1" />
        <meta name="description" content="Welcome to MB TopoFlow AI - Next.js app" />
      </Head>
      <main style={styles.main}>
        <section style={styles.card}>
          <h1 style={styles.title}>MB TopoFlow AI</h1>
          <p style={styles.subtitle}>Next.js starter page (pages/index.js)</p>
          <ul style={styles.list}>
            <li>Server time: <code>{serverTime}</code></li>
            <li>Framework: Next.js (pages router)</li>
            <li>File: pages/index.js</li>
          </ul>
          <p style={styles.note}>
            You can edit this page at <code>pages/index.js</code> and it will update on refresh.
          </p>
        </section>
      </main>
      <footer style={styles.footer}>
        <span>© {new Date().getFullYear()} MB TopoFlow AI</span>
      </footer>
    </>
  )
}

export async function getServerSideProps() {
  return {
    props: {
      serverTime: new Date().toISOString(),
    },
  }
}

const styles = {
  main: {
    minHeight: '100vh',
    display: 'flex',
    alignItems: 'center',
    justifyContent: 'center',
    padding: '2rem',
    background: 'linear-gradient(180deg, #0f172a 0%, #020617 100%)',
    color: '#e2e8f0',
  },
  card: {
    maxWidth: 720,
    width: '100%',
    background: 'rgba(15, 23, 42, 0.6)',
    border: '1px solid #1f2937',
    borderRadius: 16,
    padding: '2rem',
    boxShadow: '0 10px 30px rgba(0,0,0,0.35)'
  },
  title: {
    margin: 0,
    fontSize: '2.25rem',
    lineHeight: 1.2,
    fontWeight: 800,
    letterSpacing: '-0.02em',
    color: '#f8fafc',
  },
  subtitle: {
    marginTop: '0.5rem',
    color: '#94a3b8',
  },
  list: {
    marginTop: '1rem',
    lineHeight: 1.8,
  },
  note: {
    marginTop: '1rem',
    fontSize: '0.95rem',
    color: '#cbd5e1',
  },
  footer: {
    textAlign: 'center',
    padding: '1.5rem 0',
    color: '#94a3b8',
    borderTop: '1px solid #1f2937',
    background: '#0b1220'
  }
}
